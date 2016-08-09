package com.itheima.mobilesafe.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.itheima.mobilesafe.utils.SPUtils;
import com.itheima.mobilesafe.utils.SpDateUtil;
import com.itheima.mobilesafe88.R;


/*
<style name="myselfdialog"  parent="@android:style/Theme.Dialog">
        <item name="android:windowNoTitle">true</item> <!-- themes.xml中的属性 -->
        <item name="android:windowBackground">@android:color/white</item> <!-- themes.xml中的属性 -->
    	 <item name="android:windowAnimationStyle">@style/AnimationInputMethod</item>
    </style>

*/


public class AddressBgDialog extends Dialog {

	public AddressBgDialog(Context context) {
		super(context, R.style.myselfdialog);
		//通过LayoutParams可以自定义特有属性
		Window window = getWindow();
		//生成WindowManager的LayoutParams,Window没有LayoutParams
		LayoutParams params = window.getAttributes();
		//LayoutParams params = new WindowManager.LayoutParams(); new出的对象不作用于此Dialog,不起作用
		params.gravity = Gravity.BOTTOM;
		
	}
	//数据源
	private static final String[] mTitles = new String[] { "半透明", "活力橙", "卫士蓝", "金属灰",
	"苹果绿" };
	private static final int[] mBgs = new int[] { R.drawable.toast_view_default,
		R.drawable.toast_view_orange, R.drawable.toast_view_blue,
		R.drawable.toast_view_gray, R.drawable.toast_view_green };
	private ListView lv_addressbg;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_addressbh);
		lv_addressbg = (ListView) findViewById(R.id.lv_addressbg);
		lv_addressbg.setAdapter(new MyBaseAdapter());
		lv_addressbg.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				SPUtils.putParam(getContext(), SpDateUtil.BGSTATE, mBgs[position]);
				dismiss();
			}
		});
		
		/*Window window = getWindow();
		LayoutParams params = window.getAttributes();
		params.gravity = Gravity.BOTTOM;*/
	}
	
	class MyBaseAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return mTitles.length;
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			View view = null;
			if(convertView == null){
				view = View.inflate(getContext(), R.layout.items_addressbg, null);
				System.out.println("-------- new-------");
			}else{
				view = convertView;
			}
			TextView tv_bgname = (TextView) view.findViewById(R.id.tv_bgname);
			ImageView iv_bgshape = (ImageView) view.findViewById(R.id.iv_bgshape);
			 ImageView iv_bgstate = (ImageView) view.findViewById(R.id.iv_bgstate);
			
			tv_bgname.setText(mTitles[position]);
			iv_bgshape.setImageResource(mBgs[position]);
			
			int value = SPUtils.getInt(getContext(), SpDateUtil.BGSTATE, R.drawable.toast_view_default);
			
			if(value == mBgs[position] ){
				iv_bgstate.setVisibility(View.VISIBLE);
			}else{
				iv_bgstate.setVisibility(View.INVISIBLE);
			}
			//此处必须进行else语句设置,因为展示数据肯定会调用到缓存的view对象,缓存的对象会让显示出现异常,所以必须进行设置
			/*if(value == mBgs[position]){
				iv_bgstate.setVisibility(View.VISIBLE);
			}*/
			
			return view;
		}
		
	}
}
