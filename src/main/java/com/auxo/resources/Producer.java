package com.auxo.resources;

import org.json.simple.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Producer {
//    public static void main(String[] args) throws IOException {
//        parseThis("hello");
//
//    }
    //"E:\\Txt\\sample2.txt"
    public String findByWord(String value,String path) throws IOException {
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        String s;



        while((s=br.readLine())!=null)
        {

            if(s.indexOf(value)==0)
            {
//                System.out.println(s);
                return s;
            }

        }
        return  "hello";
    }
    public JSONObject  parseThis(String path) throws IOException {
            JSONObject object=new JSONObject();

            Map map=new LinkedHashMap(4);
            Producer producer=new Producer();

            String name,street,city,post,phone,addres,email;
            name=producer.findByWord("Name:",path);
            map.put("name",name.substring(6,name.length())   );
        Map address=new LinkedHashMap(3);
        street=producer.findByWord("Street Name:",path);
            address.put("street name",street.substring(12,street.length()));
            city=producer.findByWord("City:",path);
        address.put("city",city.substring(6,city.length()));
        post=producer.findByWord("Postal Code:",path);
        address.put("postatl code",post.substring(12,post.length()));
            map.put("address",address);
            phone=producer.findByWord("Phone:",path);
            map.put("phone",phone.substring(7,phone.length()));
        if("hello"==producer.findByWord("Mail:",path))
        {
            email=producer.findByWord("Email Address:",path);
            map.put("email", email.substring(15,email.length()));

        }else
        {
            email=producer.findByWord("Mail:",path);
            map.put("email", email.substring(6,email.length()));
        }

        object.put("patient",map);


return object;

    }
}
