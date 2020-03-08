<%! public int sum(int a,int b){
	return (a+b);
}
%>
<%! public int sub(int a,int b){
	return (a-b);
}
%>
<%! public int mul(int a,int b){
	return (a*b);
}
%>
<%! public double div(int a,int b){
	return ((double)(a/b));
}
%>
<%!
	int m=15;
	int n=2;
 %>
sum::<%= sum(m,n) %><br>

sub::<%= sub(m,n) %><br>

mul::<%= mul(m,n) %><br>

div::<%= div(m,n) %>