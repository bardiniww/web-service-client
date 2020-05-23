import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class GetRequest {
    static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) {

        CloseableHttpResponse response1 = null;

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=синхрафазатрон+в+дубне");

            response1 = httpClient.execute(httpGet);

            HttpEntity entity1 = response1.getEntity();
            System.out.println(EntityUtils.toString(entity1));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                response1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
