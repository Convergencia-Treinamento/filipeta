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
		
		Map<String, Map<String, Object>> linha1 = new HashMap<String, Map<String,Object>>();
		
		Map<String, Object> esquerda = new HashMap<String, Object>();
		esquerda.put("txDesconto", 10);
		esquerda.put("linhaCategoria", "categoria 2");
		esquerda.put("linha1", "remedios");
		esquerda.put("linha2", "teste2");
		linha1.put("esquerda", esquerda);
		
		Map<String, Object> direita = new HashMap<String, Object>();
		direita.put("txDesconto", 15);
		direita.put("linhaCategoria", "categoria 3");
		direita.put("linha1", "conveniência");
		direita.put("linha2", "teste3");
		linha1.put("direita", direita);

		
		DetailData dd = new DetailData();
		dd.setData(linha1);
		itens.add(dd);
		
		Map<String, Map<String, Object>> linha2 = new HashMap<String, Map<String,Object>>();
		
		Map<String, Object> esquerda2 = new HashMap<String, Object>();
		esquerda2.put("txDesconto", 10);
		esquerda2.put("linhaCategoria", "categoria 4");
		esquerda2.put("linha1", "remedios");
		esquerda2.put("linha2", "teste2");
		linha2.put("esquerda2", esquerda2);
		
		Map<String, Object> direita2 = new HashMap<String, Object>();
		direita2.put("txDesconto", 15);
		direita2.put("linhaCategoria", "categoria 5");
		direita2.put("linha1", "conveniência");
		direita2.put("linha2", "teste3");
		linha2.put("direita2", direita2);

		
		DetailData dd2 = new DetailData();
		dd2.setData(linha2);
		itens.add(dd2);
		
		
       
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
		
		
		System.out.println(parametros);
		
		JRBeanCollectionDataSource jrbcd = new JRBeanCollectionDataSource(itens);
		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("filipeta.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, parametros, jrbcd);
		JasperExportManager.exportReportToPdfFile(print, "filipetagerada.pdf");
		System.out.println("Relatório gerado.");
		
		
		//((java.util.Map)$F{data}.get("esquerda")).get("linha1")
		//((java.util.Map)$F{data}.get("esquerda")).get("linhaCategoria")"		 
		//((java.util.Map)($P{filipeta}.get("destaqueCima")).get(0)).get("txDesconto")+" de desconto"
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
		//((java.util.Map)((java.util.List)$P{filipeta}.get("itens")).get(0)).get("txDesconto");
	}

}
