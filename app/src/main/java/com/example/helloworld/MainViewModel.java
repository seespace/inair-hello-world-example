package com.example.helloworld;

import android.graphics.drawable.BitmapDrawable;

import inair.app.IAContext;
import inair.data.ViewModel;

public class MainViewModel extends ViewModel {
  public MainViewModel(IAContext context) {
    super(context);

    setPhotoSrc(((BitmapDrawable) getResources().getDrawable((R.drawable.photo2))));
    setPhotoTitle("Amazing Photo");
    setPhotoDescription("Lorem Ipsum Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Donec sed odio dui.");
  }

  private BitmapDrawable photoSrc;
  private String photoTitle;
  private String photoDescription;

  // Getters & Setters
  public BitmapDrawable getPhotoSrc() {
    return photoSrc;
  }

  public void setPhotoSrc(BitmapDrawable photoSrc) {
    this.photoSrc = photoSrc;
    notifyPropertyChanged("photoSrc");
  }

  public String getPhotoTitle() {
    return photoTitle;
  }

  public void setPhotoTitle(String photoTitle) {
    this.photoTitle = photoTitle;
    notifyPropertyChanged("photoTitle");
  }

  public String getPhotoDescription() {
    return photoDescription;
  }

  public void setPhotoDescription(String photoDescription) {
    this.photoDescription = photoDescription;
    notifyPropertyChanged("photoDescription");
  }
}
