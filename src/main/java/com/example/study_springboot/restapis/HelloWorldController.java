package com.example.study_springboot.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboot.service.HelloWorldService;

@Controller()
public class HelloWorldController {
    @Autowired // DI
    HelloWorldService helloworldservice;

    // cap만 씌우면 url이 어떤 class로 동작되는지 list정도는 들어가게됨.
    // dispather?랑은 다른느낌???
    // method를 사용하겠다고 이름지정하는게 아니라 들어올때 그것을 사용하겠다고 캡으로 표시하고 연결해줌
    @GetMapping("/helloWorld")
    // annotation 방식. getmapping을 함으로써 url에서 들어올때 바로 이 method로 들어옴.
    public int helloWorld() {
        // 기본적으로 page로 가게 설정되어있음. 여기서 db로 뱡향을 잡아줘야함.
        // servlet에선 request와 response로 나뉘어서 받고 나갔는데
        // spring에선 받아 들어온 것들이 각각 분리됨.

        return 0;
    }

    // url/helloWorldGetRequest?Name=yojubla&Id=aaa_html과 html로 받아서 진행됨.
    // url/helloWorldGetRequest/yojulab 이런 방식으로 읽히면서 yojulab이 Name이라는 것을 자동 인식.
    // why? location 값으로 으로 Name인걸 아는것임.
    // url/helloWorldGetRequest?Name=yojubla&Id=aaa 이렇게 던지고 싶다면 이건 /yojulab/aaa 이렇게
    // 알 수 있는건가? 위치값으로 인식한다고 했으니?맞대 ㅋㅋ
    // url/helloWorldGetRequest?Name=yojubla&Id=aaa
    @GetMapping("/helloWorldGetRequest/{Name}/{Id}")
    public int helloWorldGetRequest(@PathVariable String Name, @PathVariable String Id) {
        // url에서 날아오는 url/{Name}/{Id}를 parameter로 받아야함.
        // @PathVariable 로 들어오는 위치가 변수라는걸 알려줘야함.
        // 이 방식은 변수 2개 이하일때.. 조금 적을때 사용.
        return 0;
    }

    // ?serviceKey=DjjQE%2BvGc5kMVNOcaNx7%2FgDmIV5yRBfasWMyAKBL8YZfeHN%2F58P1075ZkOavgiZMftisiLh867rg8avoNxL8IQ%3D%3D
    // &currentPage=1
    // &perPage=10
    // &SN=1
    // /helloWorldResponse/1/10/1
    @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponse(@PathVariable String currentPage, @PathVariable String perPage,
            @PathVariable String SN) {
        // "spm_row": 471,
        // "SN": 1,
        // "CMPNM": "로이유통",
        // "RDNMADR": null
        // 이런 방식으로 hashmap 하기.
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        // 이 hashmap은 final DB에서 가져오고있는것.
        // ResponseEntity<Object> <GENERIC>이란 이 CLASS에 넣을 수 잇는 DATA TYPE을 정해둔것. (OBJECT가
        // 들어가는건 최상위에 OBJECT이기 때문에 어느거나 허용 가능)
        // RETURN 할때 BODY와 HEADER를 같이 보냄요.
        return ResponseEntity.ok().body(resultMap);
    }

    // {
    // "CMPNM": "로이유통",
    // "spm_row": 471,
    // "RDNMADR": null,
    // "SN": 1
    // } 보내면 결과가 이렇게 나오는데 그럼 currentpage, perpage도 표시하려면 Hashmap에 넣어야하는건가?
    // 아니면 db의 위치라는건가????????????
    // /helloWorldResponseList/1/10/1
    @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage,
            @PathVariable String SN) {
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }

    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage,
            @PathVariable String perPage,
            @PathVariable String SN) {
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3

        // 존재하던 arraylist를 helloworldservice로 옮김 거기서 가져와서 출력할거임.
        ArrayList arrayList = new ArrayList();
        new HelloWorldService();
        arrayList = helloworldservice.fakeSelect(currentPage, perPage);
        // IoC
        return ResponseEntity.ok().body(arrayList);
    }
// /helloWorldResponseFake/?
// db_cars 에서 가져온것. 
    @GetMapping("/helloWorldResponseFake/{companyId}")
    public ResponseEntity<Object> helloWorldResponseFake(@PathVariable String companyId) {

        ArrayList arrayList = new ArrayList();
        new HelloWorldService();
        helloworldservice.fakeSelect(companyId);

        return ResponseEntity.ok().body(arrayList);
    }
}