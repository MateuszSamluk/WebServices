package com.example.webservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsBookActivity extends AppCompatActivity {

    private static final String IMAGE_URL_BASE = "http://covers.openlibrary.org/b/id/";
    Book book;
    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private TextView numberOfPagesTextView;
    private ImageView bookCover;
    private TextView firstReleaseDateTextView;
    private TextView languageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_book);
        book = (Book)getIntent().getSerializableExtra("clickedBook");
        bookTitleTextView = findViewById(R.id.book_title_details);
        bookAuthorTextView = findViewById(R.id.book_author_details);
        numberOfPagesTextView = findViewById(R.id.number_of_pages_details);
        bookCover = findViewById(R.id.img_cover_details);
        firstReleaseDateTextView = findViewById(R.id.first_release_date);
        languageTextView = findViewById(R.id.language);

        if(book.getCover() != null){
            Picasso.with(this)
                    .load(IMAGE_URL_BASE + book.getCover() + ".jpg")
                    .fit()
                    .placeholder(R.drawable.ic_baseline_book_24).into(bookCover);
        }else{
            bookCover.setImageResource(R.drawable.ic_baseline_book_24);
        }

        bookTitleTextView.setText(getResources().getString(R.string.book_title, book.getTitle()));
        bookAuthorTextView.setText(getResources().getString(R.string.book_authors,
                TextUtils.join(", ", book.getAuthors())));
        numberOfPagesTextView.setText(getResources().getString(R.string.book_number_of_page, book.getNumberOfPages()));
        firstReleaseDateTextView.setText(getResources().getString(R.string.book_first_release, book.getFirsReleaseDate()));
        languageTextView.setText(getResources().getString(R.string.book_language,
                TextUtils.join(", ", book.getLanguage())));
    }
}