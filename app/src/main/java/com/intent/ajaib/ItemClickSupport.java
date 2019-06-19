package com.intent.ajaib;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemClickSupport
//{
//    private RecyclerView recyclerView;
//    private OnItemClickListener onItemClickListener;
//    private OnItemLongClickListener onItemLongClickListener;
//
//    private ItemClickSupport(RecyclerView recyclerView){
//        recyclerView = recyclerView;
//        recyclerView.setTag(R.id.item_click_support, this);
//        recyclerView.addOnChildAttachStateChangeListener(attachStateChangeListener);
//    }
//
//    private View.OnClickListener onClickListener = new View.OnClickListener(){
//
//        @Override
//        public void onClick(View v){
//            if (onItemClickListener != null){
//                RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(v);
//                onItemClickListener.onItemClicked(recyclerView, holder.getAdapterPosition(), v);
//            }
//        }
//    };
//
//    private View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(){
//
//        @Override
//        public boolean onLongClick(View v){
//            if (onItemLongClickListener != null){
//                RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(v);
//                return onItemLongClickListener.onItemLongClicked(recyclerView, holder.getAdapterPosition(), v);
//            }
//            return false;
//        }
//    };
//
//    private RecyclerView.OnChildAttachStateChangeListener attachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() {
//        @Override
//        public void onChildViewAttachedToWindow(View view) {
//            if (onItemClickListener != null){
//                view.setOnClickListener(onClickListener);
//            }
//            if (onItemLongClickListener != null){
//                view.setOnLongClickListener(onLongClickListener);
//            }
//        }
//
//        @Override
//        public void onChildViewDetachedFromWindow(@NonNull View view) {
//
//        }
//    };
//
//    public static ItemClickSupport addTo (RecyclerView view){
//        ItemClickSupport support = (ItemClickSupport)view.getTag(R.id.item_click_support);
//        if (support == null){
//            support = new ItemClickSupport(view);
//        }
//        return support;
//    }
//
//    public static ItemClickSupport removeFrom(RecyclerView view){
//        ItemClickSupport support = (ItemClickSupport)view.getTag(R.id.item_click_support);
//        if(support != null){
//            support.detach(view);
//        }
//        return support;
//    }
//
//    public ItemClickSupport setOnItemClickLIstener (OnItemClickListener listener){
//        onItemClickListener = listener;
//        return this;
//    }
//
//    public ItemClickSupport setOnItemLongClickListener(OnItemLongClickListener listener){
//        onItemLongClickListener = listener;
//        return this;
//    }
//
//    private void detach(RecyclerView view) {
//        view.removeOnChildAttachStateChangeListener(attachStateChangeListener);
//        view.setTag(R.id.item_click_support, null);
//    }
//
//    public interface OnItemClickListener{
//        void onItemClicked(RecyclerView recyclerView, int position, View v);
//    }
//
//    public interface OnItemLongClickListener{
//        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
//    }
//
//}

{
    private final RecyclerView mRecyclerView;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    private ItemClickSupport(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mRecyclerView.setTag(R.id.item_click_support, this);
        mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                mOnItemClickListener.onItemClicked(mRecyclerView, holder.getAdapterPosition(), v);
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            if (mOnItemLongClickListener != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                return mOnItemLongClickListener.onItemLongClicked(mRecyclerView, holder.getAdapterPosition(), v);
            }
            return false;
        }
    };
    private RecyclerView.OnChildAttachStateChangeListener mAttachListener
            = new RecyclerView.OnChildAttachStateChangeListener() {

        @Override
        public void onChildViewAttachedToWindow(View view) {
            if (mOnItemClickListener != null) {
                view.setOnClickListener(mOnClickListener);
            }
            if (mOnItemLongClickListener != null) {
                view.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(View view) {
        }
    };

    public static ItemClickSupport addTo(RecyclerView view) {
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support == null) {
            support = new ItemClickSupport(view);
        }
        return support;
    }

    public static ItemClickSupport removeFrom(RecyclerView view) {
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if (support != null) {
            support.detach(view);
        }
        return support;
    }

    public ItemClickSupport setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        return this;
    }

    public ItemClickSupport setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
        return this;
    }

    private void detach(RecyclerView view) {
        view.removeOnChildAttachStateChangeListener(mAttachListener);
        view.setTag(R.id.item_click_support, null);
    }

    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
    }
}
