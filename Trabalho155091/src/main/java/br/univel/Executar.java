package br.univel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

public class Executar {

		
		public static void main(String[] args) throws IOException {
			
			Marshaller marshaller = null;
			Clientes c = new Clientes();
			c.setId(2);
			c.setNome("Erick Cauê Gomes");
			c.setEndereco("Rua Vilma Richter Martins");
			c.setNumero(100);
			c.setComplemento("Casa");
			c.setBairro("Jardim Recanto dos Pássaros II");
			c.setCidade("São João da Boa Vista");
			c.setEstado("SP");
			c.setCep(85410000);
			c.setTelefone(3241578);
			c.setCelular(888888888);
			StringWriter out = new StringWriter();
			JAXBContext context = null;
			
			try{
				
				context = JAXBContext.newInstance(c.getClass());
				marshaller = context.createMarshaller();
				marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
				marshaller.marshal(c, new StreamResult(out));
				
			}catch(PropertyException e){
				e.printStackTrace();
			}catch(JAXBException e){
				e.printStackTrace();
			}
			String xml = out.toString();
			FileWriter fw = new FileWriter("arquivo.xml");
			fw.write(xml);
			fw.close();
			
			System.out.println(xml);
			System.out.println("Dados obtidos do arquivo.xml\n");
			
			//Ler xml
			
			try {

				Unmarshaller um = context.createUnmarshaller();
				Object obj = um.unmarshal(new File("arquivo.xml"));
				
				Clientes cliente = (Clientes) obj;
				System.out.println("ID = "+cliente.getId());
				System.out.println("Nome = "+cliente.getNome());
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

}
