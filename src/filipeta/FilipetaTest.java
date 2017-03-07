package filipeta;

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





public class FilipetaTest {


	public static void main(String[] args) throws JRException {
		Map<String, Object> filipeta = new HashMap<String, Object>();
		
		filipeta.put("nome", "Morgana Matheus M Andrade");
        
		Map<String, Object> mapa = new HashMap<String, Object>();
		List<Map<String, Object>> itens = new ArrayList<Map<String,Object>>();
        
		Map<String, Object> destaqueCima = new HashMap<String, Object>();
		destaqueCima.put("txDesconto", "20");
		destaqueCima.put("linhaCategoria", "categoria 1");
		destaqueCima.put("linha1", "perfume");
		destaqueCima.put("linha2", "teste1");
		filipeta.put("destaqueCima", destaqueCima);

		Map<String, Object> item2 = new HashMap<String, Object>();
		Map<String, Object> linha2 = new HashMap<String, Object>();
		itens.add(item2);
		item2.put("txDesconto", "10");
		item2.put("linhaCategoria", "categoria 2");
		linha2.put("linha1", "remedios");
		linha2.put("linha2", "teste2");
		item2.put("linhaMarca2", linha2);

		Map<String, Object> item3 = new HashMap<String, Object>();
		Map<String, Object> linha3 = new HashMap<String, Object>();
		itens.add(item3);
		item3.put("txDesconto", "15");
		item3.put("linhaCategoria", "categoria 3");
		linha3.put("linha1", "conveniência");
		linha3.put("linha2", "teste3");
		item3.put("linhaMarca3", linha3);

		Map<String, Object> item4 = new HashMap<String, Object>();
		Map<String, Object> linha4 = new HashMap<String, Object>();
		itens.add(item4);
		item4.put("txDesconto", "10");
		item4.put("linhaCategoria", "categoria 4");
		linha4.put("linha1", "cosmeticos");
		linha4.put("linha2", "teste4");
		item4.put("linhaMarca4", linha4);

		Map<String, Object> item5 = new HashMap<String, Object>();
		Map<String, Object> linha5 = new HashMap<String, Object>();
		itens.add(item5);
		item5.put("txDesconto", "10");
		item5.put("linhaCategoria", "categoria 5");
		linha5.put("linha1", "caixa");
		linha5.put("linha2", "teste5");
		item5.put("linhaMarca5", linha5);
		
		
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
        
		System.out.println(filipeta);
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("filipeta", filipeta);
		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("filipeta.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, parametros);
		JasperExportManager.exportReportToPdfFile(print, "filipetagerada.pdf");
		System.out.println("Relatório gerado.");
		
		
		
		//((java.util.Map)($P{filipeta}.get("destaqueCima")).get(1)).get("txDesconto")+" de desconto"		 
		//((java.util.Map)($P{filipeta}.get("destaqueCima")).get(0)).get("txDesconto")+" de desconto"
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
	}

}
