<%
println value.collect{ item ->
    item.toString()
}.join(', ')
%>