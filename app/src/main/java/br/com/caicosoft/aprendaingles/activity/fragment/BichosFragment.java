package br.com.caicosoft.aprendaingles.activity.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.caicosoft.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private Button btnCao, btnGato, btnVaca, btnOvelha, btnLeao, btnMacaco;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        btnCao = view.findViewById(R.id.btnCao);
        btnGato = view.findViewById(R.id.btnGato);
        btnVaca = view.findViewById(R.id.btnVaca);
        btnOvelha = view.findViewById(R.id.btnOvelha);
        btnLeao = view.findViewById(R.id.btnLeao);
        btnMacaco = view.findViewById(R.id.btnMacaco);

        btnCao.setOnClickListener(this);
        btnGato.setOnClickListener(this);
        btnVaca.setOnClickListener(this);
        btnOvelha.setOnClickListener(this);
        btnLeao.setOnClickListener(this);
        btnMacaco.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.btnGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.btnLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.btnMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.btnVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
            case R.id.btnOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release(); // SEMPRE LIBERAR RECURSOS
                }
            });
        }
    }
}
