package sample.application.calculator;



import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class CalculatorActivity extends Activity {
	
	public String num1 = new String();/*stringインスタンスを変数に入れている*/
	private String strTemp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
   
    public void numKeyOnClick(View v){//数字のボタン
    	Button button = (Button)v;
    	Log.d("[buttonのtext]",button.getText().toString());
    	TextView tv = (TextView) this.findViewById(R.id.displayPanel);
    	Log.d("[tvのインスタンスか確認]","tv.text:"+tv.getText().toString());
    	tv.setText(tv.getText());/*ここまで一桁表示*/
    	tv.setText(tv.getText().toString() + button.getText());/*文字をつなげる*/
    }  
    
    
    public void numOnClick(View v){
    	String strInKey = (String) ((Button)v).getText();//strInKeyにボタン格納（必要なTextのみ）
    	
    	if(strInKey.equals(".")){
    		if(this.strTemp.length() == 0){
    			this.strTemp="0.";
    		}else{
    			if(this.strTemp.indexOf(".")==-1){
    				this.strTemp = strTemp+".";
    			}
    		}
    	}else{
    		this.strTemp=this.strTemp+strInKey;
    	}
    	//インスタンス変数渡してる
    	this.showNuber(this.strTemp);
    }
    
    private void showNuber(String strNum){
    	//this.strTemp;
    	DecimalFormat form = new DecimalFormat("#,##0");//#は数字のこと
    	String strDecimal = "";
    	String strInt = "";
    	String fText = "";
    	
    	if(strNum.length()>0){
    		int decimalPoint = strNum.indexOf(".");
    		if(decimalPoint>-1){
    			strDecimal = strNum.substring(decimalPoint);
    			strInt = strNum.substring(0,decimalPoint);//0から開始
    		}else{
    			strInt = strNum;
    		}
    		fText = form.format(Double.parseDouble(strInt))+strDecimal;
    	}else fText = "0";
    	((TextView)findViewById(R.id.displayPanel)).setText(fText);//displayPanelを呼び出しfTextをセットする
    	
    }
    
    public void addKeyOnClick(View v){//
    	Log.d("[addkeyが実行されるか確認]","test");
    	//String num1 = null;//表示されている数字の保存領域
    	TextView tv = (TextView) this.findViewById(R.id.displayPanel);
    	Log.d("[tvのインスタンスか確認]","tv.text:"+tv.getText().toString());
    	Log.d("addkeypが呼ばれてすぐ",this.num1);//thisはCalculatorActivity*インスタンス化されてないと使えない
    	this.num1 = tv.getText().toString();//表示している文字をstring肩に換えて変数に格納、thisはCalculatorActivity型
    	Log.d("",this.num1);
    	//num1 = tv.getText().toString();
    	tv.setText("0");
    }
    
    public void equalKeyOncliic(View v){
    	Log.d("[addkeyが実行されるか確認]","test");
    	Log.d("equaley でのnum1",this.num1);
    	//新しく表示された数字を取得
    	//nul1に保存した最初の数字を取得
    	//上二つを足す。
    	
    }
    
    
}
