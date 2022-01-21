package com.softtek.labelling.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;

@RestController
@RequestMapping(value = "/ocr")
public class OcrController {
	
	public static void makeGray(BufferedImage img)
	{
	    for (int x = 0; x < img.getWidth(); ++x)
	    for (int y = 0; y < img.getHeight(); ++y)
	    {
	        int rgb = img.getRGB(x, y);
	        int r = (rgb >> 16) & 0xFF;
	        int g = (rgb >> 8) & 0xFF;
	        int b = (rgb & 0xFF);

	        // Normalize and gamma correct:
	        double rr = Math.pow(r / 255.0, 2.2);
	        double gg = Math.pow(g / 255.0, 2.2);
	        double bb = Math.pow(b / 255.0, 2.2);

	        // Calculate luminance:
	        double lum = 0.2126 * rr + 0.7152 * gg + 0.0722 * bb;

	        // Gamma compand and rescale to byte range:
	        int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
	        int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
	        img.setRGB(x, y, gray);
	    }
	}
	
	@PostMapping()
	public ResponseEntity<String> traduzir(@RequestParam(name="file") MultipartFile file) throws Exception{
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		if (!"png".equals(ext) && !"jpg".equals(ext)) {
			return ResponseEntity.badRequest().build();
		}
		
		String resultado = "";
		
		try {
			BufferedImage img = ImageIO.read(file.getInputStream());
			makeGray(img);
			
			//Em versões anteriors do tesseract seria Tesseract.getInstance()
	        Tesseract tesseract = new Tesseract();
	        //Path da pasta pai onde fica a pasta "tessdata"
	        tesseract.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");
	        resultado = "";	     
	        //lingua: por, eng etc...
            tesseract.setLanguage("eng");
			resultado = tesseract.doOCR(img);	        
		} catch (IOException e) {
			throw new Exception("Erro ao ler arquivo");
		}
		return ResponseEntity.ok(resultado);						
	}
	
}
