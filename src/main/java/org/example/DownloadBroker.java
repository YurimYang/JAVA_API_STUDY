package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;

import java.io.FileOutputStream;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadBroker extends Thread {
    //스레드가 처리하는 작업 클래스
    private String imageUrl;
    private String imageName;
    private HttpClient httpClient;
    public void run(){
        try {
            HttpGet httpGet = new HttpGet(imageUrl); //Get방식으로 요청
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();

            //버퍼에 저장한 후에 다운로드
            byte[] imgBuf = EntityUtils.toByteArray(entity);
            FileOutputStream fos = new FileOutputStream(imageName);
            fos.write(imgBuf);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
