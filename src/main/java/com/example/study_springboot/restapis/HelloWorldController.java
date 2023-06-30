package com.example.study_springboot.restapis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller()
public class HelloWorldController {
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
        return 0;
    }
}