package com.liuwan.customdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liuwan.customdialog.widget.CustomDialog;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button logout, cancel, confirm;
    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_confirm, null);
        customDialog = new CustomDialog(this, 0.83, 0.22, view, R.style.customDialogStyle);
        // 点击对话框以外的地方，对话框不消失。按返回键对话框会消失。
        customDialog.setCanceledOnTouchOutside(false);
        // 点击对话框以外的地方，对话框不消失。按返回键对话框也不消失。
        customDialog.setCancelable(false);
        TextView prompt = (TextView) view.findViewById(R.id.prompt);
        prompt.setText("退出当前账户？");
        cancel = (Button) view.findViewById(R.id.cancel);
        confirm = (Button) view.findViewById(R.id.confirm);
        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logout:
                customDialog.show();
                break;

            case R.id.cancel:
                customDialog.dismiss();
                break;

            case R.id.confirm:
                customDialog.dismiss();
                this.finish();
                break;

        }
    }

}
