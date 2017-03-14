package filipeta;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class FilipetaTest {


	public static void main(String[] args) throws JRException {
		Map<String, Object> filipeta = new HashMap<String, Object>();
		
		filipeta.put("nome", "Morgana Matheus M Andrade");
        
		List<DetailData> itens = new ArrayList<>();
		
		Map<String, Map<String, Object>> linha = new HashMap<String, Map<String,Object>>();
		Map<String, Object> esquerda = new HashMap<String, Object>();
		esquerda.put("txDesconto", 10);
		esquerda.put("linhaCategoria", "categoria 2");
		esquerda.put("linha1", "remedios");
		esquerda.put("linha2", "teste2");
		linha.put("esquerda", esquerda);
		
		Map<String, Object> direita = new HashMap<String, Object>();
		direita.put("txDesconto", 15);
		direita.put("linhaCategoria", "categoria 3");
		direita.put("linha1", "conveniência");
		direita.put("linha2", "teste3");
		linha.put("direita", direita);
		
		esquerda.put("txDesconto1", "10");
		esquerda.put("linhaCategoria1", "categoria 4");
		esquerda.put("linha3", "cosmeticos");
		esquerda.put("linha4", "teste4");
		
		direita.put("txDesconto1", 10);
		direita.put("linhaCategoria1", "categoria 5");
		direita.put("linha3", "caixa");
		direita.put("linha4", "teste3");
		linha.put("direita", direita);
		
		DetailData dd = new DetailData();
		dd.setData(linha);
		itens.add(dd);
		
		for (DetailData detailData : itens) {
			System.out.println(detailData.getData());
		}
       
		Map<String, Object> destaqueCima = new HashMap<String, Object>();
		destaqueCima.put("txDesconto", "20");
		destaqueCima.put("linhaCategoria", "categoria 1");
		destaqueCima.put("linha1", "perfume");
		destaqueCima.put("linha2", "teste1");
		filipeta.put("destaqueCima", destaqueCima);

		/*//Map<String, Object> item2 = new HashMap<String, Object>();
		List<Map<String,Object>> detail = new ArrayList<Map<String,Object>>();
		Map<String, Object> linha2 = new HashMap<String, Object>();
		Map<String, Object> item2 = new HashMap<String, Object>();
		detail.add(item2);
		item2.put("txDesconto", "10");
		item2.put("linhaCategoria", "categoria 2");
		linha2.put("linha1", "remedios");
		linha2.put("linha2", "teste2");
		item2.put("linhaMarca2", linha2);
		filipeta.put("detail", item2);
		
		

		Map<String, Object> item3 = new HashMap<String, Object>();
		Map<String, Object> linha3 = new HashMap<String, Object>();
		detail.add(item3);
		item3.put("txDesconto", "15");
		item3.put("linhaCategoria", "categoria 3");
		linha3.put("linha1", "conveniência");
		linha3.put("linha2", "teste3");
		item3.put("linhaMarca3", linha3);
		filipeta.put("detail", item3);

		Map<String, Object> item4 = new HashMap<String, Object>();
		Map<String, Object> linha4 = new HashMap<String, Object>();
		detail.add(item4);
		item4.put("txDesconto", "10");
		item4.put("linhaCategoria", "categoria 4");
		linha4.put("linha1", "cosmeticos");
		linha4.put("linha2", "teste4");
		item4.put("linhaMarca4", linha4);
		filipeta.put("detail", item4);

		Map<String, Object> item5 = new HashMap<String, Object>();
		Map<String, Object> linha5 = new HashMap<String, Object>();
		detail.add(item5);
		item5.put("txDesconto", "10");
		item5.put("linhaCategoria", "categoria 5");
		linha5.put("linha1", "caixa");
		linha5.put("linha2", "teste5");
		item5.put("linhaMarca5", linha5);
		filipeta.put("detail", item5);
		
		for (Map<String, Object> map : detail) {
		System.out.println(map);
		}*/
		
		//List<Map<String, Object>> ofertas = new ArrayList<Map<String,Object>>();

		Map<String, Object> destaqueBaixo = new HashMap<String, Object>();
		destaqueBaixo.put("produto1", "fralda");
		destaqueBaixo.put("valor1","9,99");
		destaqueBaixo.put("produto2", "fraldão");
		destaqueBaixo.put("valor2","8,99");
		filipeta.put("destaqueBaixo", destaqueBaixo);

		filipeta.put("cpf","999.999.999-99");

		//List<Map<String, Object>> validades = new ArrayList<Map<String,Object>>();
		

	
		//filipeta.put("filipeta", mapa);

		Map<String, Object> validade1 = new HashMap<String, Object>();
		validade1.put("validade1", "28/11/2016");
		validade1.put("validade2", "04/12/2016");
		filipeta.put("validades", validade1);
        
		
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("filipeta", filipeta);
		//System.out.println(detail.get(0));
		
		//System.out.println(parametros);
		
		
		JRBeanCollectionDataSource jrbcd = new JRBeanCollectionDataSource(itens);
		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("filipeta.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, parametros, jrbcd);
		JasperExportManager.exportReportToPdfFile(print, "filipetagerada.pdf");
		System.out.println("Relatório gerado.");
		
		
		
		//((java.util.Map)($P{filipeta}.get("destaqueCima")).get(1)).get("txDesconto")+" de desconto"		 
		//((java.util.Map)($P{filipeta}.get("destaqueCima")).get(0)).get("txDesconto")+" de desconto"
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
	}

}
