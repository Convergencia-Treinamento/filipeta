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
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("nome", "Morgana Matheus M Andrade");

		List<Map<String, Object>> itens = new ArrayList<Map<String,Object>>();
		mapa.put("itens", itens);

		Map<String, Object> item1 = new HashMap<String, Object>();
		Map<String, Object> linha1 = new HashMap<String, Object>();
		itens.add(item1);
		item1.put("txDesconto", "20");
		item1.put("linhaCategoria", "categoria 1");
		linha1.put("linha1", "perfume");
		linha1.put("linha2", "teste1");
		item1.put("linhaMarca1", linha1);

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
		linha3.put("linha1", "remedios");
		linha3.put("linha2", "teste3");
		item3.put("linhaMarca3", linha3);

		Map<String, Object> item4 = new HashMap<String, Object>();
		Map<String, Object> linha4 = new HashMap<String, Object>();
		itens.add(item4);
		item4.put("txDesconto", "10");
		item4.put("linhaCategoria", "categoria 4");
		linha4.put("linha1", "remedios");
		linha4.put("linha2", "teste4");
		item4.put("linhaMarca4", linha4);

		Map<String, Object> item5 = new HashMap<String, Object>();
		Map<String, Object> linha5 = new HashMap<String, Object>();
		itens.add(item5);
		item5.put("txDesconto", "10");
		item5.put("linhaCategoria", "categoria 4");
		linha5.put("linha1", "remedios");
		linha5.put("linha2", "teste2");
		item5.put("linhaMarca5", linha5);

		List<Map<String, Object>> ofertas = new ArrayList<Map<String,Object>>();
		mapa.put("ofertas", ofertas);

		Map<String, Object> oferta1 = new HashMap<String, Object>();
		oferta1.put("produto1", "fralda");
		oferta1.put("valor1","9,99");
		oferta1.put("produto2", "fralda");
		oferta1.put("valor2","9,99");
		ofertas.add(oferta1);

		mapa.put("cpf","999.999.999-99");

		List<Map<String, Object>> validades = new ArrayList<Map<String,Object>>();
		mapa.put("validades", validades);
		
		Map<String, Object> filipeta = new HashMap<String, Object>();
		filipeta.put("filipeta", mapa);

		Map<String, Object> validade1 = new HashMap<String, Object>();
		validade1.put("validade1", "28/11/2016");
		validade1.put("validade2", "04/12/2016");
		validades.add(validade1);

		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("filipeta.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, filipeta);
		JasperExportManager.exportReportToPdfFile(print, "filipetagerada.pdf");
		System.out.println("Relatório gerado.");
		
		
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
	}

}
