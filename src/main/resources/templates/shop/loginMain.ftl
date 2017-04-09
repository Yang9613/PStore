<#include "../commons/top.ftl" encoding="utf-8" parse="true">
<form method="post" action="login" commandName="user">


	<table align="center" border="0">
		<tr>
			<td colspan="2">
				<span style="color: red">
					<#if error??>
                        ${error}
                    </#if>
				</span>
				<br />
				&nbsp;
			</td>
		</tr>
		<tr>
			
			<td>
				用户名：<input type="text" id="username" name="username">
			</td>
		</tr>
		<tr>
			
			<td>
				密&nbsp;码：<input type="password" id="password" name="password">
			</td>
		</tr>
		<tr>

			<td colspan="2" align="center">
				<input type="image" border="0" src="../images/button_submit.gif" />
			</td>
		</tr>
	</table>

<center>
	<a href="rmain"><img border="0"
			src="../images/button_register_now.gif" />
	</a>
</center>
</form>
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true">