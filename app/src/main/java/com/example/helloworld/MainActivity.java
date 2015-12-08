package com.example.helloworld;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import java.util.ArrayList;

import inair.app.IAActivity;
import inair.event.Event;
import inair.input.TouchEventArgs;
import inair.view.UIView;

public class MainActivity extends IAActivity {

  public static final String TAG = "Hello World";

  private ArrayList<MainViewModel> mViewModels = new ArrayList<>();

  @Override
  public void onInitialize(Bundle bundle) {
    setRootContentView(R.layout.activity_main);

    // Create 5 view models holding data of our photo
    MainViewModel viewModel1 = new MainViewModel(this);
    viewModel1.setPhotoSrc((BitmapDrawable) getResources().getDrawable(R.drawable.photo1));
    viewModel1.setPhotoTitle("Pharetra Dapibus");
    viewModel1.setPhotoDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");

    MainViewModel viewModel2 = new MainViewModel(this);
    viewModel2.setPhotoSrc((BitmapDrawable) getResources().getDrawable(R.drawable.photo2));
    viewModel2.setPhotoTitle("Commodo Dapibus");
    viewModel2.setPhotoDescription("Nullam id dolor id nibh ultricies vehicula ut id elit.");

    MainViewModel viewModel3 = new MainViewModel(this);
    viewModel3.setPhotoSrc((BitmapDrawable) getResources().getDrawable(R.drawable.photo3));
    viewModel3.setPhotoTitle("Tristique Vestibulum");
    viewModel3.setPhotoDescription("Cras justo odio, dapibus ac facilisis in, egestas eget quam.");

    MainViewModel viewModel4 = new MainViewModel(this);
    viewModel4.setPhotoSrc((BitmapDrawable) getResources().getDrawable(R.drawable.photo4));
    viewModel4.setPhotoTitle("Quam Bibendum");
    viewModel4.setPhotoDescription("Morbi leo risus, porta ac consectetur ac, vestibulum at eros.");

    MainViewModel viewModel5 = new MainViewModel(this);
    viewModel5.setPhotoSrc((BitmapDrawable) getResources().getDrawable(R.drawable.photo5));
    viewModel5.setPhotoTitle("Nullam Ridiculus");
    viewModel5.setPhotoDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");

    // add into mViewModels array, so we can use later
    mViewModels.add(viewModel1);
    mViewModels.add(viewModel2);
    mViewModels.add(viewModel3);
    mViewModels.add(viewModel4);
    mViewModels.add(viewModel5);

    // by default, we display photo1
    setDataContext(viewModel1);

    // Listen to double tap event
    addViewEventListener(UIView.DoubleTapEvent, onDoubleTap);
  }

  // Trigger a `next()` when user performs double tap
  private Event.Listener<TouchEventArgs> onDoubleTap = new Event.Listener<TouchEventArgs>() {
    @Override
    public void onTrigger(Object o, TouchEventArgs args) {
      next();
    }
  };

  // switch to next view model, trigger a change so layout will be automatically updated
  private void next() {
    MainViewModel currentViewModel = (MainViewModel) getDataContext();
    int currentIndex = mViewModels.indexOf(currentViewModel);
    int nextIndex = currentIndex + 1;
    if (nextIndex == mViewModels.size()) {
      nextIndex = 0;
    }
    setDataContext(mViewModels.get(nextIndex));
  }
}
