package coljamkop.home_teacher;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import coljamkop.home_teacher.dummy.AppointmentContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdditionalFragment extends Fragment {

    AddAppointmentFragmentInteractionListener mListener;

    public AdditionalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_additional, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                EditText name = (EditText) view.findViewById(R.id.editFamilyName);
                EditText date = (EditText) view.findViewById(R.id.editDate);
                EditText time = (EditText) view.findViewById(R.id.editTime);
                mListener.onAddAppointmentButtonPress(new AppointmentContent.Appointment(
                        name.getText().toString(),
                        date.getText().toString(),
                        time.getText().toString()));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddAppointmentFragmentInteractionListener) {
            mListener = (AddAppointmentFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface AddAppointmentFragmentInteractionListener {
        void onAddAppointmentButtonPress(AppointmentContent.Appointment appointment);
    }
}
