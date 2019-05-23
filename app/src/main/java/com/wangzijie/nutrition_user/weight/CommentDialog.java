package com.wangzijie.nutrition_user.weight;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.wangzijie.nutrition_user.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentDialog extends Dialog {

    @BindView(R.id.tv_commit)
    TextView tv_commit;//提交
    @BindView(R.id.et_context)
    EditText et_comment;//评论内容
    private Context context;
    private OnCommitListener listener;

    public CommentDialog(Context context) {
        this(context, R.style.inputDialog);
        this.context = context;
    }

    public CommentDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_dialog_layout);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        //设置显示对话框时的返回键的监听
        this.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getRepeatCount() == 0)
                    CommentDialog.this.cancel();
                return false;
            }
        });
    }

    public void setOnCommitListener(OnCommitListener listener) {
        this.listener = listener;
    }


    @OnClick({ R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_commit:
                if (null != listener) {
                    listener.onCommit(et_comment, view);
                }
                break;
        }
    }

    public interface OnCommitListener {

        void onCommit(EditText et, View v);//提交数据

    }


    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setAttributes(layoutParams);
    }
}
