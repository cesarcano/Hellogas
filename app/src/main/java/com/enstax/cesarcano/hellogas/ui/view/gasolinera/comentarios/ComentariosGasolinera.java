package com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.ComentariosGasPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.TabFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ComentariosGasolinera extends TabFragment implements  ComentGasContract.View {
    private String idgasolinera;
    private ComentGasContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_gasolinera_comentarios, container, false);
        ButterKnife.bind(this, view);
        presenter = new ComentariosGasPresenter(getContext(), this);
        presenter.getComentarios(idgasolinera);
        return view;
    }

    public void setIdgasolinera(String idgasolinera) {
        this.idgasolinera = idgasolinera;
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        hideProgressDialog();
    }

    @Override
    public void loadList(ArrayList<Comentario> comentarios) {
        hideProgressDialog();
    }

    @Override
    public void loadMComent(Comentario comentario) {
        hideProgressDialog();
    }

    @Override
    public void likeComent(Boolean b) {
        showProgressDialog();
    }

    @Override
    public void updateComent(String id) {

    }

    @Override
    public void loadComent(Comentario comentario) {

    }
}