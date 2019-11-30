package com.example.bintada;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> implements RecyclerView.OnItemTouchListener {
    private final List<Contact> contactList;

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        Button info;
        Button numero;
        Button surnom;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            this.info = itemView.findViewById(R.id.nompre);
            this.numero = itemView.findViewById(R.id.numero);
            this.surnom = itemView.findViewById(R.id.surnom);
        }
    }

    public ContactAdapter(List<Contact> contactList) {
        this.contactList    = contactList;
    }



    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
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

    public interface OnItemClickListener {

        //void onItemClick(Contact contact);

        void onItemClick(View view, int position);
    }




}
