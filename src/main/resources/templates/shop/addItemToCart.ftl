<#include "../commons/top.ftl" encoding="utf-8" parse="true">
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top" width="20%" align="left">
			<table align="left" bgcolor="#008800" border="0" cellspacing="2"
				cellpadding="2">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="main.xhtml"><b><font color="BLACK" size="2">&lt;&lt; 主菜单</font>
				</b></a>
					</td>
				</tr>
			</table>
		</td>
		<td valign="top" align="center">
			<h2 align="center">
				
			</h2>
			<form name="form1" method="post"
				action="/cart/update">
				
				<table align="center" bgcolor="#008800" border="0" cellspacing="2"
					cellpadding="5" >
					<tr bgcolor="#cccccc">
                        <td>
                            宠物编号
                        </td>
                        <td>
                            产品序号
                        </td>
                        <td>
                            宠物描述
                        </td>
                        <td>
                            <b>是否有宠物</b>
                        </td>
                        <td width="100">
                            宠物单价
                        </td>
                        <td>
                            宠物数量
                        </td>
                        <td>
                            合计
                        </td>
                        <td>
                            &nbsp;
                        </td>
					</tr>

					<#assign oid=0/>
					<#assign sum=0/>
					<#list clist as cart>
						<#list cart.ilist as item>
					<tr bgcolor="#FFFF88">
						<td>
							<b>
								<input type="hidden" value="${item.itemid}" name="itemid">
								<a href="">${item.itemid}</a>
							
							</b>
						</td>
						<td>
							
							${item.product.productid}
						</td>
						<td>

							${item.product.descn}
						</td>
						<td align="center">
						
							是
						</td>
						<td>
							${item.listprice}
														
						</td>
						<td align="right">
                            <input type="number" value="${cart.quantity}" name="qty"/>
							<br/>
						</td>
						<td align="right">
							<#assign sum=sum+item.listprice*cart.quantity/>
							${item.listprice*cart.quantity}
						</td>
						<#assign oid=cart.orderid?c />
                        <input type="hidden" value="${cart.orderid?c}" name="oid">
						<td>
							<a href="/cart/in_itemid/${item.itemid}/in_orderid/${cart.orderid?c}">
								<img border="0" src="/images/button_remove.gif" />
							</a>
						</td>
					</tr>
						</#list>
					</#list>

					<tr bgcolor="#FFFF88">
						<td colspan="7" align="right">
                            <input type="image" src="/images/button_update_cart.gif">
							<b>
                                总计：${sum}
							</b>							
							
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
				<center>


				</center>
			</form>


			<br />
			<center>
				<a href="/cart/check/in_orderid/${oid}/total/${sum?c}"><img border="0"
						src="/images/button_checkout.gif" />
				</a>
			</center>


		</td>


		<td valign="top" width="20%" align="right">
		<#include "../shop/favItem.ftl" encoding="utf-8" parse="true">
		</td>

	</tr>
</table>

<br>
<#include "../commons/banner.ftl" encoding="utf-8" parse="true">
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true">