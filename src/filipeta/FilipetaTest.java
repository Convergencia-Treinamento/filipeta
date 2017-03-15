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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class FilipetaTest {


	public static void main(String[] args) throws JRException {
		Map<String, Object> filipeta = new HashMap<String, Object>();
		
		filipeta.put("topo", "http://www.agenciadosite.com.br/wp-content/uploads/2014/07/logo-essencialperfumes-300x225.jpg");
		
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
		
		Map<String, Object> destaqueBaixo = new HashMap<String, Object>();
		destaqueBaixo.put("produto1", "Fralda");
		destaqueBaixo.put("valor1","9,99");
		destaqueBaixo.put("produto2", "Rivotril");
		destaqueBaixo.put("valor2","8,99");
		filipeta.put("destaqueBaixo", destaqueBaixo);

		filipeta.put("cpf","999.999.999-99");

		Map<String, Object> validade1 = new HashMap<String, Object>();
		validade1.put("validade1", "28/11/2016");
		validade1.put("validade2", "04/12/2016");
		filipeta.put("validades", validade1);
        
		
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("filipeta", filipeta);
		
		
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
