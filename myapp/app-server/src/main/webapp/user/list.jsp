<%@ page
    language="java" 
    contentType="text/html;charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ page import="bitcamp.myapp.vo.User"%>
<%@ page import="java.util.List"%>

<jsp:include page="/header"/>

<h1>회원 목록</h1>
<p><a href='/user/form'>새 회원</a></p>
<table>
  <thead>
      <tr><th>번호</th><th>이름</th><th>이메일</th></tr>
  </thead>
  <tbody>
<%
List<User> list = (List<User>) request.getAttribute("list");
for (User user : list) {
out.println(String.format("      <tr><td>%d</td><td><a href='/user/view?no=%1$d'>%s</a></td><td>%s</td></tr>",
        user.getNo(), user.getName(), user.getEmail()));
}
%>
  </tbody>
</table>


</body>
</html>