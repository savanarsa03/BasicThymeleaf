/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TakeHome.TakeHome2;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author savan_ks1jekz
 */
@Controller
public class controller {
    @RequestMapping("/th1")
    //@ResponseBody
    public String getTake(@RequestParam(value="nama") String nama,
                            @RequestParam(value="lahir") String tgl,
                            @RequestParam(value="foto") MultipartFile ph,
                            Model model )
        
        throws IOException{
        
        byte[] img = ph.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String link = "data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimnama", nama);
        model.addAttribute("kirimtgl", tgl);
        model.addAttribute("kirimph", link);
        return "main" ;
    }
}

