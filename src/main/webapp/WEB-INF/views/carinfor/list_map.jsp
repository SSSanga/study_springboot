<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.HashMap, java.util.ArrayList" %>
     <!-- list_map 에서 delete&selectSearch를 진행하고자 함.     -->
    <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>carInfo list</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
        </head>

        <body>

            <!-- Menu -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="#">Logo</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">About</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Contact</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <% HashMap Params=(HashMap)request.getAttribute("params"); 
            String searchSTR=(String)Params.getOrDefault("search", "" ); 
            HashMap Result=(HashMap)request.getAttribute("result");
            %>
                <!-- 이렇게 받고 삼항조건 () ? ;으로 select option에 풀어버려????? -->
<!-- 세번째 HASHMAP의 안에는 RESULT = deleteand selectsearch로 받은 걸 넣을라고 ...ㅎㅎ -->
                <!-- Main Content -->
                <div class="container mt-4">
                    <div class="row">
                        <div class="col-md-8">
                            <h2>Search</h2>
                            <div class="input-group mb-3">
                                <form action="/carInfor/selectSearch" method="get">
                                    <select class="form-select" name="search">
                                        <option selected>Select an option...</option>
                                        <option value="YEAR" <%=(searchSTR.equals("YEAR") ) ? "selected" : "" %>> YEAR
                                        </option>
                                        <option value="CAR_NAME" <%=(searchSTR.equals("CAR_NAME") ) ? "selected" : "" %>
                                            > CAR_NAME</option>
                                    </select>
                                    <!-- select는 serchSTR.equals의 year를 비교해서 참이면 select하고 거짓이면 ""을 뱉는다 -->
                                    <input type="text" name="words" value='<%= Params.getOrDefault("words","") %>'
                                        class="form-control" placeholder="Search..." id="keydownEnter">
                                    <button class="btn btn-primary" type="submit">Go</button>
                                </form>
                            </div>
                            <h2>Table</h2>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Car Name</th>
                                        <th>YEAR</th>
                                        <th>ID</th>
                                        <th>Manufacturer ID</th>
                                        <th>DELETE</th>
                                    </tr>
                                </thead>
                                <tbody id="carTableBody">

                                    <!-- Empty -->
                                    <!-- 이부분을 for문 돌리면서 arrayList로 풀어버린다.  -->
                                    <!-- 받을때는 Controller에서 modelAndView.addObject("result", result)로 들어온 result를 getAttribute한다 -->
                                    <% ArrayList resultList=(ArrayList)Result.get("resultList"); for(int i=0 ; i <
                                        resultList.size();i=i+1){ HashMap record=(HashMap)resultList.get(i); %>
                                        <form>
                                            <input type="hidden" name="CAR_INFOR_ID" value='<%= record.get("CAR_INFOR_ID") %>' id="">

                                            <tr>
                                                <td>
                                                    <%= record.get("CAR_NAME") %>
                                                </td>
                                                <td>
                                                    <%= record.get("YEAR") %>
                                                </td>
                                                <td>
                                                    <%= record.get("CAR_INFOR_ID") %>
                                                </td>
                                                <td>
                                                    <%= record.get("COMPANY_ID") %>
                                                </td>
                                                <td><button formaction="/carInfor/deleteAndSelectSearch"
                                                        formmethod="post">DEL</button>
                                            </tr>
                                        </form>
                                        <% } %>

                                </tbody>
                            </table>
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>

                <!-- Footer -->
                <footer class="bg-dark text-white text-center py-4 mt-4">
                    <div class="container">
                        <p>&copy; 2023 Your Website. All Rights Reserved.</p>
                    </div>
                </footer>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        </body>

        </html>