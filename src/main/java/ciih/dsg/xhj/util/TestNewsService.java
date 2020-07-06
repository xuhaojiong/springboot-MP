package ciih.dsg.xhj.util;

//文件读写类
import java.io.File;
import java.util.List;
//webbservice调用类
import ciih.dsg.xhj.entity.Article;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
//客户端封装文件类


public class TestNewsService {
    public static void main(String[] args) {
            //WebService的具体路径
            String serverpath = "http://10.100.21.7:8080/system/services/NewsService";
            //创建 Service实例
            Service service = new Service();
            Call call;
            try
            {
                //通过Service实例创建Call的实例
                call = (Call)service.createCall();
                //将Web Service的服务路径加入到call实例之中，设置服务的位置
                call.setTargetEndpointAddress(serverpath);

                //调用服务中的getOwners()方法，
                //注意，此方法invoke有两个参数：
                //参数getOwners：文章webservice接口中的getOwners()接口
                //参数null:getOwners()接口用的参数，因为此接口无参数，所以这里使用了null
                //返回值a为String[] ，不同的接口返回值不同，您需要在这里做转换
                String a=(String)call.invoke("getlistByTime", new Object[] {"1244220609","2019-01-01","2020-05-01"});

                if(a==null)
                {
                    System.out.println("callOwners no data!");
                }
//                for(int i=0;i<a.length;i++)
//                {
//                    System.out.println("owner#name:"+a[i]);
//                }
                System.out.println(a);

            } catch (Exception e)
            {
                e.printStackTrace();
            }

    }
}
