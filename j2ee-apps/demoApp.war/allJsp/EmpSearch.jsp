<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#call').click(function ()
            {
                $.ajax({
                    type: "post",
                    url: "./EmployeeDetails.jsp?empid="+$("#empId").val(),//this is my servlet
                    success: function(msg){      
                            $('#output').append(msg);
                    }
                });
            });

        });
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
   Employee Number:<input id="empId" type="text"  /><br></br>
    <input type="button" value="Search" name="Search" id="call"/>
    <div id="output"></div>
</body>