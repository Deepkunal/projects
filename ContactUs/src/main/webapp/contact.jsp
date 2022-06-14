<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
form 
{
	font-family: Arial, Helvetica, sans-serif;
    width: 300px;
    margin: 0 auto;
    border: 3px solid black;
    padding-top:50px;
    padding-bottom:50px;
    padding-right:100px;
    padding-left:100px;
     background-color: white;
}

 input[type=text], input[type=E-mail] 
 {
  
  width: 100%; 
  padding: 12px; 
  border: 1px solid #ccc; 
  border-radius: 4px; 
  box-sizing: border-box; 
  margin-top: 6px; 
  margin-bottom: 16px; 
  resize: vertical 
}
input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 2px;
  cursor: pointer;
  text-align:centre;
}
input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<meta charset="UTF-8">
<title>contactushere</title>
</head>
<body>
<div class="container">
  <div style="text-align:center">
    <h2>Contact Us</h2>
    <h3>please fill this form in a decent manner:</h3>
  </div>
  
      <form action="ContctUsServlet" method="post">
        <label for="fullname">Full Name</label><br>
        <input type="text" id="fullname" name="fullname" placeholder="Your name.."><br>
        <label for="E-mail">E-mail:</label><br>
         <input type="E-mail" id="E-mail" name="email" placeholder="your email"><br>
        
        <label for="Message">Message</label><br>
        <textarea id="Message" name="Message" placeholder="Write something.." style="height:100px"></textarea><br>
        <input type="submit" value="submit">
      </form>
 </div>
</body>
</html>