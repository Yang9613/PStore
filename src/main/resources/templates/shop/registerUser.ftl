<#include "../commons/top.ftl" encoding="utf-8" parse="true">
<br/>

<form id="form1" name="form1" method="post" action="register" commandName="user">
	<TABLE cellpadding=10 cellspacing=0 align=center border=1 width="400"
		bgcolor=#dddddd>
		<TR>
			<TD>
				<FONT color=darkgreen>
					<H3>
						用户信息
					</H3>
				</FONT>
				<TABLE border=0  bgcolor=#FFFF88  width="100%">
					<TR bgcolor=#FFFF88>						
						<TD>
						 	用户名:<input type="text" id="username" name="username">
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
							 
							密&nbsp;码:<input type="text" id="password" name="password">
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
							确认密码:<input type="text" id="repassword" name="repassword">
                            <span style="color: red">
								<#if errorPwd??>
                        			${errorPwd}
                    			</#if>
							</span>
						</TD>
					</TR>
				</TABLE>





				<FONT color=darkgreen><H3>
							账户信息
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 
					bgcolor=#FFFF88 width="100%">
					<TR bgcolor=#FFFF88>
						
						<TD>
							 姓名:<input type="text" id="xm" name="xm">
                            <span style="color: red">
								<#if errorXm??>
                        			${errorXm}
                    			</#if>
							</span>
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						
						<TD>
							邮箱:<input type="text" id="email" name="email">
                            <span style="color: red">
								<#if errorEmail??>
                        			${errorEmail}
                    			</#if>
							</span>
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						
						<TD>
							 
							地址:<input type="text" id="address" name="address">
						</TD>
					</TR>
					
					
				</TABLE>


				<FONT color=darkgreen><H3>
						 喜爱设置

					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 cellpadding=3 cellspacing=1 width="100%">
					<TR bgcolor=#FFFF88>
						
						<TD>
							语言设置:<select name="profile.lang">
                            <option value="english">
                                英语
                            </option>
                            <option value="chinese">
                                汉语
                            </option>
                        </select>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
							喜爱宠物:
							<select name="profile.catid">
							<#list clist as category>

								<option value="${category.catid}">
									${category.name}
								</option>

							</#list>
                            </select>
						</TD>
					</TR>
					
				</TABLE>
	</TABLE>

	<BR>
	<CENTER>
		<input border=0 type="image" src="../images/button_submit.gif" />
	</CENTER>
</form>
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true">