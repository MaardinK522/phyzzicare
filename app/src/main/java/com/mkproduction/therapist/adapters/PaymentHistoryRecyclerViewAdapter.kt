package com.mkproduction.therapist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mkproduction.therapist.R
import com.mkproduction.therapist.models.AmountHistory
import kotlin.random.Random

class PaymentHistoryRecyclerViewAdapter(
    val context: Context, private val mAmountHistoryArrayList: ArrayList<AmountHistory>
) : RecyclerView.Adapter<PaymentHistoryRecyclerViewAdapter.PaymentHistoryView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentHistoryView {
        return PaymentHistoryView(
            LayoutInflater.from(context)
                .inflate(R.layout.payment_profile_fragment_history_item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mAmountHistoryArrayList.size
    }

    override fun onBindViewHolder(holder: PaymentHistoryView, position: Int) {
        val amountHistory = mAmountHistoryArrayList[position]
        holder.mPersonImageView.setImageBitmap(amountHistory.mPersonBitmap)
        holder.mPersonNameTextView.text = amountHistory.mPersonName
        holder.mPersonPaymentAmount.text = "\u20B9 " + Random.nextInt(100, 1000)
    }

    class PaymentHistoryView(view: View) : RecyclerView.ViewHolder(view) {
        var mPersonImageView: ShapeableImageView
        var mPersonNameTextView: TextView
        var mPersonPaymentAmount: TextView

        init {
            mPersonImageView = view.findViewById(R.id.payment_history_person_imageview)
            mPersonNameTextView = view.findViewById(R.id.payment_history_person_name_textview)
            mPersonPaymentAmount = view.findViewById(R.id.payment_history_person_amount_textview)
        }
    }
}