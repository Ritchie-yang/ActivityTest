package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
       //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.camera_item:
               // Toast.makeText(this,"you clicked add",Toast.LENGTH_SHORT).show();
                Intent intent_camera =new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent_camera);//拍照
                break;
            case R.id.tel_item:
                //Toast.makeText(this,"you clicked Remove",Toast.LENGTH_SHORT).show();
                Intent intent_tel = new Intent(Intent.ACTION_DIAL);
                intent_tel.setData(Uri.parse("tel:18603767663"));
                startActivity(intent_tel);//调用电话
                break;
            default:

        }
        return  true;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is"+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
               // Toast.makeText(FirstActivity.this,"You clicked button 1",Toast.LENGTH_SHORT).show();
                 //finish();//退出
                /*Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);//隐式intent*/


               /* Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent); //调用浏览器*/

               /* Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);//调用电话*/
               /* String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);//向后传达数据*/
             /*   Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);*/
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);

                SecondActivity.actionStart(FirstActivity.this,"data1","data2");

            }
        });


    }
    @Override
    protected  void onActivityResult(int requestCode,int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected  void  onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }

}
