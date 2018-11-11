package vn.edu.itdlu.a1610234.dhdl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SubjectsInfoDialog {

    public SubjectsInfoDialog(Activity activity, String id, String name, String type, Integer number) {
        this.activity = activity;
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
        this.dialog = createDialog();
    }

    private Dialog createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();

        View view = inflater.inflate(R.layout.subjects_info_dialog, null);
        TextView idTextView = view.findViewById(R.id.idContent);
        TextView nameTextView = view.findViewById(R.id.name);
        TextView typeTextView = view.findViewById(R.id.type);
        TextView numberTextView = view.findViewById(R.id.number);
        idTextView.setText(this.id);
        nameTextView.setText(this.name);
        typeTextView.setText(this.type);
        numberTextView.setText(this.number.toString());

        builder.setView(view);
        return builder.create();
    }

    public SubjectsInfoDialog show() {
        dialog.show();
        return this;
    }

    private Dialog dialog;
    private Activity activity;
    private String id;
    private String name;
    private String type;
    private Integer number;
}
