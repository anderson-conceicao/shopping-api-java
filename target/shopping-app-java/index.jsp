<p style="text-align: center;">Shopping API - Rest</p>
<table border="1" style="border-collapse: collapse; width: 100%; height: 201px;">
<tbody>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;">End-points</td>
<td style="width: 25.1061%; height: 21px;">Descri&ccedil;&atilde;o</td>
<td style="width: 31.1572%; height: 21px;">Dados de entradas</td>
</tr>
<tr style="height: 33px;">
<td style="width: 10.4034%; height: 33px;"><span>http://localhost:8080/shopping-app-java/webapi/lojas/cadastrar</span></td>
<td style="width: 25.1061%; height: 33px;">Cadastrar uma nova loja.</td>
<td style="width: 31.1572%; height: 33px;">
<div>
<div><span>&nbsp;Exemplo: onde 1 &eacute; para situa&ccedil;&atilde;o ativa e 0 inativa;</span></div>
<div><span> {</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"nome"</span><span>:&nbsp;</span><span>"casa&nbsp;e&nbsp;video"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"cnpj"</span><span>:&nbsp;</span><span>"000.000.0000.003"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"id"</span><span>:&nbsp;</span><span>1</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"piso"</span><span>:&nbsp;</span><span>"2&ordm;Piso"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"numero"</span><span>:&nbsp;</span><span>"201"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"tipoSituacao"</span><span>:&nbsp;</span><span>"1",</span></div>
<div>
<div>
<div><span>"segmentos"</span><span>:&nbsp;{</span><span>"id"</span><span>:</span><span>"1"</span><span>,</span><span>"nome"</span><span>:</span><span>"perfumaria"</span><span>}</span></div>
</div>
</div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;}</span></div>
</div>
</td>
</tr>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;"><span>http://localhost:8080/shopping-app-java/webapi/lojas</span></td>
<td style="width: 25.1061%; height: 21px;">Listar todas as lojas.</td>
<td style="width: 31.1572%; height: 21px;">N/A</td>
</tr>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;"><span>http://localhost:8080/shopping-app-java/webapi/lojas/id</span></td>
<td style="width: 25.1061%; height: 21px;">Listar uma loja especifica.</td>
<td style="width: 31.1572%; height: 21px;">Passar o n&uacute;mero do ID na URI</td>
</tr>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;"><span>http://localhost:8080/shopping-app-java/webapi/lojas/alterar/id</span></td>
<td style="width: 25.1061%; height: 21px;">Alterar dados de uma loja.</td>
<td style="width: 31.1572%; height: 21px;">
<div><span>Passar o n&uacute;mero do ID do registro a ser alterado na URI</span></div>
<div><span>Exemplo:</span></div>
<div><span>{</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"nome"</span><span>:&nbsp;</span><span>"casa&nbsp;e&nbsp;video"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"cnpj"</span><span>:&nbsp;</span><span>"000.000.0000.003"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"id"</span><span>:&nbsp;</span><span>1</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"piso"</span><span>:&nbsp;</span><span>"2&ordm;Piso"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"numero"</span><span>:&nbsp;</span><span>"201"</span><span>,</span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"tipoSituacao"</span><span>:&nbsp;</span><span>"1",</span></div>
<div>
<div>
<div><span>&nbsp;"segmentos"</span><span>:&nbsp;{</span><span>"id"</span><span>:</span><span>"1"</span><span>,</span><span>"nome"</span><span>:</span><span>"perfumaria"</span><span>}</span></div>
</div>
</div>
<div><span></span></div>
<div><span>&nbsp;&nbsp;&nbsp;&nbsp;}</span></div>
</td>
</tr>
<tr style="height: 33px;">
<td style="width: 10.4034%; height: 33px;"><span>http://localhost:8080/shopping-app-java/webapi/segmentos/cadastrar</span></td>
<td style="width: 25.1061%; height: 21px;">Cadastrar um segmento.</td>
<td style="width: 31.1572%; height: 21px;">Exemplo:<br />
<div>
<div><span>{</span><span>"nome"</span><span>:</span><span>"perfumaria"</span><span>}</span></div>
</div>
</td>
</tr>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;"><span>http://localhost:8080/shopping-app-java/webapi/segmentos</span></td>
<td style="width: 25.1061%; height: 21px;">Listar todos os segmentos.</td>
<td style="width: 31.1572%; height: 21px;">N/A</td>
</tr>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;"><span>http://localhost:8080/shopping-app-java/webapi/segmentos/id</span></td>
<td style="width: 25.1061%; height: 21px;">Listar um segmento especifico.</td>
<td style="width: 31.1572%; height: 21px;">Passar o n&uacute;mero do ID na URI</td>
</tr>
<tr style="height: 21px;">
<td style="width: 10.4034%; height: 21px;"><span>http://localhost:8080/shopping-app-java/webapi/segmentos/alterar/id</span></td>
<td style="width: 25.1061%; height: 21px;">Alterar dados de um segmento.</td>
<td style="width: 31.1572%; height: 21px;">
<p>Passar o n&uacute;mero do ID do registro a ser alterado na URI</p>
<p>Exemplo:</p>
<div>
<div><span>{</span><span>"nome"</span><span>:</span><span>"perfumaria"</span><span>}</span></div>
</div>
</td>
</tr>
</tbody>
</table>