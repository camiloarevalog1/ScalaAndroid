package cristhian.com.scalascarlosarturo;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MiFirebaseServiceInstaceIdService extends FirebaseInstanceIdService {

    public static final String TAG="ScalasCarlosArturo";

    String token=FirebaseInstanceId.getInstance().getToken();



    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token=FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG,token);

        Log.e("Token",token);

    }




}