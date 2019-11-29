package com.example.bintada;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bintada.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHoloder> {
    List<Contact> contactList;

    public static class ContactViewHoloder extends RecyclerView.ViewHolder {

        Button info;
        Button numero;
        Button surnom;

        public ContactViewHoloder(@NonNull View itemView) {
            super(itemView);
            this.info = itemView.findViewById(R.id.nompre);
            this.numero = itemView.findViewById(R.id.numero);
            this.surnom = itemView.findViewById(R.id.surnom);
        }
    }

    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHoloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ContactViewHoloder contactViewHoloder = new ContactViewHoloder(view);
        return contactViewHoloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHoloder holder, int position) {
        Contact contact = contactList.get(position);
        String infoText = contact.getNom() + "  " + contact.getPrenom();
        String phone    = Integer.toString(contact.getNumero());
        holder.info.setText(infoText);
        holder.numero.setText(phone);
        holder.surnom.setText(contact.getSurnom());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


}
