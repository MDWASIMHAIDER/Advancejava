<% 
	int a=10;
	out.println(a*a);
%>
<br>
<%
	out.println("browser name"+request.getHeader("user-agent"));
 %>
 <br>
 <%
 	String msg="hello";
 	out.println(msg.length());
  %><br>
  <%!
  	public String sayHello(){
  		return "good morning";
  	}
   %>
   <%=sayHello()
   	
   %><br>
   <%out.println(sayHello()); %>
   <%
   		String s=null;
   		out.print(s);
   		//out.write(s);
   		out.println(s);
    %><br>
    <jsp:scriptlet>
    <![CDATA[
    	int b=20;
    	int c=30;
    	if(b<c){
    		out.println("b is small");
    	}
    	else{
    		out.println("c is small");
    	}
    	]]>
    </jsp:scriptlet><br>
    <%
    	int d=20;
    	int e=30;
    	if(d>e){
    		out.println("d is small");
    	}
    	else{
    		out.println("e is small");
    	}
     %><br>
     <jsp:declaration>
     	public int findBig(int x,int y){
     		if(x>y){
     			return x;
     		}
     		else{
     			return y;
     		}
     	}
     </jsp:declaration>
     <jsp:scriptlet>out.println(findBig(13,11));</jsp:scriptlet><br>
     
     <jsp:expression>5+10</jsp:expression><br>
     10+20:<%=10+20 %><br>
     10>20?<%=10>20 %><br>
     10<20?<%=10<20 %><br>
     10/20:<%=10/20 %><br>
     <%
 	String msg1="hello";
  %><br>
  length::<%=msg1%> is <%=msg1.length() %><br>
  <%=new java.util.Date() %><br>
  <jsp:expression>new java.util.Date()</jsp:expression><br>
 
 <%!int w=23; %><br>
<%int z=24; %>
 <%=this.w %><br>
 <%=z%>
 <%! public int add(int  x,int y){
 	return x+y;
 }%><br>
 <%=add(z,this.w) %><br>
 