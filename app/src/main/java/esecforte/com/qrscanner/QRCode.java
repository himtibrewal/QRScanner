package esecforte.com.qrscanner;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 4/8/17.
 */

public class QRCode extends Application {
    private static QRCode qrCode;
    public static List<String> fixturelist = new ArrayList<String>();

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static synchronized QRCode getInstance() {
        return qrCode;
    }

}
