package net.initiativet.a62415_team8;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProposalListFragment extends Fragment {

    private OnProposalListInteractionListener mListener;
    ListView list;

    public ProposalListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_proposal_list, container, false);
        list = (ListView)v.findViewById(R.id.table);

        ArrayList<String> mainArguement = getArguments().getStringArrayList("titleList");


        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.list_cell, R.id.cell_textView, mainArguement); //<- insert array list
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mListener.onProposalListInteraction(position);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProposalListInteractionListener) {
            mListener = (OnProposalListInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProposalListInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnProposalListInteractionListener {
        void onProposalListInteraction(int position);
    }
}
