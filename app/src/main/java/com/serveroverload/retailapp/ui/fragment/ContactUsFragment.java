/*
 * Copyright 2016 Hitesh Sahu
 * Copyright 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.serveroverload.retailapp.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.thoughtworks.retailshop.R;
import com.serveroverload.retailapp.ui.activities.ECartHomeActivity;
import com.serveroverload.retailapp.util.Utils;
import com.serveroverload.retailapp.util.Utils.AnimationType;

// TODO: Auto-generated Javadoc
/**
 * Fragment that appears in the "content_frame", shows a animal.
 */
public class ContactUsFragment extends Fragment {

	private Toolbar mToolbar;

	/**
	 * Instantiates a new settings fragment.
	 */
	public ContactUsFragment() {
		// Empty constructor required for fragment subclasses
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.about_fragment, container,
				false);

		getActivity().setTitle("Contact Us");
		
		
		mToolbar = (Toolbar) rootView.findViewById(R.id.htab_toolbar);
		if (mToolbar != null) {
			((ECartHomeActivity) getActivity()).setSupportActionBar(mToolbar);
		}

		if (mToolbar != null) {
			((ECartHomeActivity) getActivity()).getSupportActionBar()
					.setDisplayHomeAsUpEnabled(true);

			mToolbar.setNavigationIcon(R.drawable.ic_drawer);

		}

		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((ECartHomeActivity) getActivity()).getmDrawerLayout()
						.openDrawer(GravityCompat.START);
			}
		});

		mToolbar.setTitleTextColor(Color.WHITE);

		rootView.findViewById(R.id.locations).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

					}
				});

		rootView.findViewById(R.id.contact_num).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						Intent callIntent = new Intent(Intent.ACTION_DIAL);
						callIntent.setData(Uri.parse("tel:" + "8888813275"));
						startActivity(callIntent);

					}
				});

		rootView.setFocusableInTouchMode(true);
		rootView.requestFocus();
		rootView.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				if (event.getAction() == KeyEvent.ACTION_UP
						&& keyCode == KeyEvent.KEYCODE_BACK) {

					Utils.switchContent(R.id.frag_container,
							Utils.HOME_FRAGMENT,
							((ECartHomeActivity) (getContext())),
							AnimationType.SLIDE_UP);

				}
				return true;
			}
		});

		rootView.findViewById(R.id.site_dev).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent browserIntent = new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("http://hiteshsahu.com/"));
						startActivity(browserIntent);

					}
				});

		rootView.findViewById(R.id.email).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						final Intent emailIntent = new Intent(
								android.content.Intent.ACTION_SEND);
						emailIntent.setType("text/plain");
						emailIntent
								.putExtra(
										android.content.Intent.EXTRA_EMAIL,
										new String[] { "hiteshkumarsahu1990@gmail.com" });
						emailIntent.putExtra(
								android.content.Intent.EXTRA_SUBJECT,
								"Hello There");
						emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
								"Add Message here");

						emailIntent.setType("message/rfc822");

						try {
							startActivity(Intent.createChooser(emailIntent,
									"Send email using..."));
						} catch (android.content.ActivityNotFoundException ex) {
							Toast.makeText(getActivity(),
									"No email clients installed.",
									Toast.LENGTH_SHORT).show();
						}

					}
				});

		return rootView;
	}

	public static Fragment newInstance() {
		// TODO Auto-generated method stub
		return new ContactUsFragment();
	}
}
