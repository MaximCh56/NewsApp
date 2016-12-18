package maxim.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {
    ItemObject itemObject;
    TextView textViewTitle;
    TextView textViewDescription;
    TextView textViewAuthor;
    TextView textViewPublishedAt;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = getIntent();
        itemObject = (ItemObject) intent.getSerializableExtra("test");
        textViewTitle=(TextView)findViewById(R.id.textViewTitle);
        textViewDescription=(TextView)findViewById(R.id.textViewDescription);
        textViewAuthor=(TextView)findViewById(R.id.textViewAuthor);
        textViewPublishedAt=(TextView)findViewById(R.id.textViewPublishedAt);
        imageView=(ImageView)findViewById(R.id.imageView);
        textViewTitle.setText(itemObject.getTitle());
        textViewDescription.setText(itemObject.getDescription());
        textViewAuthor.setText(itemObject.getAuthor());
        textViewPublishedAt.setText(itemObject.getPublishedAt());
        Picasso.with(getApplication())
                .load(itemObject.getUrlToImage())
                .into(imageView);
    }
}
