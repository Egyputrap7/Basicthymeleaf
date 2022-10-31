/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takehome1.takehome;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author asus
 */
@Controller
public class controller {
    @RequestMapping("/insert")
    public String getInsert(@RequestParam (value="nama" )String getNama,
                            @RequestParam (value="tanggal" )String getTgl,
                            @RequestParam (value="foto" )MultipartFile getFoto,                           
                            Model model)
            throws IOException{
        byte[] pict = getFoto.getBytes();
        String base64Image = Base64.encodeBase64String(pict);
        String linkPict ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("sendNama",getNama);
        model.addAttribute("sendTgl",getTgl);
        model.addAttribute("sendPict",linkPict);
        
            return "view-result";
    }  
}
