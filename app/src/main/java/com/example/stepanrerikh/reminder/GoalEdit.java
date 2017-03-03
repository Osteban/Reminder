package com.example.stepanrerikh.reminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GoalEdit extends AppCompatActivity implements View.OnClickListener{

    private Intent intentGE;

    private EditText edText;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_edit);

        edText = (EditText) findViewById(R.id.edText);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
                  switch (v.getId()){
                      case R.id.btnOk:
                          intentGE = new Intent();
                          intentGE.putExtra("nameGoal", edText.getText().toString());
                          setResult(RESULT_OK, intentGE);
                          finish();
                          break;
                      case  R.id.btnCancel:
                          finish();
                          break;
                      default:
                          break;
                  }
    }
}
