package com.mkproduction.therapist.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.mkproduction.therapist.R
import com.mkproduction.therapist.adapters.PaymentHistoryRecyclerViewAdapter
import com.mkproduction.therapist.models.AmountHistory

class PaymentFragment : Fragment() {
    private lateinit var mPaymentRecyclerView: RecyclerView
    private lateinit var mWithdrawlMoneyButton: MaterialButton
    private lateinit var mFragmentView: View
    private lateinit var amountHistoryList: ArrayList<AmountHistory>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findViews()
        amountHistoryList = ArrayList()
        generateFakeAmountTransferHistory()
        mPaymentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mPaymentRecyclerView.adapter =
            PaymentHistoryRecyclerViewAdapter(requireContext(), amountHistoryList)
    }

    private fun generateFakeAmountTransferHistory() {
        amountHistoryList.add(
            AmountHistory(
                BitmapFactory.decodeResource(
                    resources, R.drawable.doc_avatar_image
                ),
                "Mardin Kamble", 100,
            )
        )
        amountHistoryList.add(
            AmountHistory(
                BitmapFactory.decodeResource(
                    resources, R.drawable.doc_avatar_image
                ),
                "Mardin Kamble",
                100,
            )
        )
        amountHistoryList.add(
            AmountHistory(
                BitmapFactory.decodeResource(
                    resources, R.drawable.doc_avatar_image
                ),
                "Mardin Kamble",
                100,
            )
        )
        amountHistoryList.add(
            AmountHistory(
                BitmapFactory.decodeResource(
                    resources, R.drawable.doc_avatar_image
                ),
                "Mardin Kamble",
                100,
            )
        )
        amountHistoryList.add(
            AmountHistory(
                BitmapFactory.decodeResource(
                    resources, R.drawable.doc_avatar_image
                ),
                "Mardin Kamble",
                100,
            )
        )
    }

    private fun findViews() {
        mPaymentRecyclerView =
            mFragmentView.findViewById(R.id.fragment_profile_payment_history_recyclerview)
        mWithdrawlMoneyButton = mFragmentView.findViewById(R.id.fragment_payment_withdrawl_button)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mFragmentView = inflater.inflate(R.layout.fragment_payment, container, false)
        return mFragmentView
    }
}
