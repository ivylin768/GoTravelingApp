package hk.edu.cuhk.seem5760.gotraveling.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import hk.edu.cuhk.seem5760.gotraveling.R;

public class HomeFragment extends Fragment {

    private Banner banner;//初始化Banner控件
    private ArrayList<String> imagePath;
    private ImageButton fbtn;
    private ImageView iv;
    private TextView tv;


    @NonNull
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        banner = root.findViewById(R.id.banner);
        imagePath = new ArrayList<>();

        imagePath.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588421398284&di=26967f80444b18fb697ebe86a501c12b&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F469ec6b594087ce1f2d35bd24c5ef039fb6a174a752c6-ieobU1_fw658");//图片宽度658为合适
        imagePath.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588415836678&di=f5c1353f6761f29338885060243f2792&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fc20d070ca0e267a20552010949c48b81291d0abc7ccf8-2Tj8o4_fw658");
        imagePath.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588421320943&di=a8d247bbeca80123c3eb601bad8874d3&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Ff18a26cc7dfda34838ac699c9734ad3de4c89e981d576c-SlNlYT_fw658");

        final ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getContext());
        banner.setBannerAnimation(Transformer.DepthPage);//动画效果
        banner.setDelayTime(4500);//间隔时间
        banner.isAutoPlay(true);//自动轮播
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
                instance.init(configuration);
                instance.displayImage((String)path,imageView);
            }
        });
        banner.setImages(imagePath);
        banner.start();

        fbtn = (ImageButton)root.findViewById(R.id.food);
        iv = (ImageView)root.findViewById(R.id.food_imgview);
        tv = (TextView)root.findViewById(R.id.title);

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.getDrawable().setLevel(1);
                tv.setText("美食推荐");
//                tv.setVisibility(View.INVISIBLE);
            }
        });

        return root;
    }


}
