package vn.edu.itdlu.a1610234.dhdl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

interface  CustomAlertDialogAction{
    void action();
}

public class CustomAlertDialog  {
    protected CustomAlertDialog(Activity activity,
                                String message,
                                String okTitle,
                                CustomAlertDialogAction okAction,
                                String cancelTitle,
                                CustomAlertDialogAction cancelAction) {
        this.activity = activity;
        this.message = message;
        this.okTitle = okTitle;
        this.cancelTitle = cancelTitle;
        this.okAction = okAction;
        this.cancelAction = cancelAction;
        dialog = makeBuilder().create();
        dialog.show();
    }

    protected CustomAlertDialog(Activity activity,
                                String message,
                                String cancelTitle,
                                CustomAlertDialogAction cancelAction) {
        this.activity = activity;
        this.message = message;
        this.cancelTitle = cancelTitle;
        this.cancelAction = cancelAction;
        dialog = makeBuilder().create();
        dialog.show();
    }

    protected CustomAlertDialog(Activity activity,
                                String message,
                                String cancelTitle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setNegativeButton(cancelTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        }).setMessage(message);

        dialog = builder.create();
        dialog.show();
    }

    private AlertDialog.Builder makeBuilder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (okTitle != null){
            builder.setPositiveButton(okTitle, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    if (okAction != null) {
                        okAction.action();
                    }
                }
            });
        }

        if (cancelTitle != null) {
            builder.setNegativeButton(cancelTitle, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    if (cancelAction != null)
                        cancelAction.action();
                    else
                        dismiss();
                }
            });
        }

        builder.setMessage(message);
        return builder;
    }

    public void show(){
        dialog.show();
    }

    public void dismiss(){
        dialog.dismiss();
    }

    private AlertDialog dialog;
    private String message;
    private String okTitle;
    private String cancelTitle;
    private CustomAlertDialogAction okAction;
    private CustomAlertDialogAction cancelAction;
    private Activity activity;
}
