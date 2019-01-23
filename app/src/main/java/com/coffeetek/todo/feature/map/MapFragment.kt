package com.coffeetek.todo.feature.map

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.coffeetek.todo.R
import com.coffeetek.todo.base.ui.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import javax.inject.Inject


/**
 * Create by Mr.X on 1/13/19
 */
class MapFragment : BaseFragment(), MapFragmentContract.View, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private var googleMap: GoogleMap? = null
    private var prevMarker: Marker? = null

    @Inject
    internal lateinit var presenter: MapFragmentContract.Presenter

    companion object {
        fun newInstance(): MapFragment {
            val args = Bundle()
            val fragment = MapFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun showStoreInfo(storeViewModel: StoreViewModel) {
        BottomSheetStoreInfo.newInstance(storeViewModel).show(childFragmentManager, "BottomSheetStoreInfo")
    }

    override val contentView: Int
        get() = R.layout.fragment_map

    override fun initView(view: View?) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun initEvent() {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        this.googleMap?.setOnMarkerClickListener(this)

        presenter.renderMarker()
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        unSelectedMarker(prevMarker)
        selectedMarker(marker)

        prevMarker = marker

        presenter.getStoreInfo(marker?.tag as MarkerViewModel)

        return true
    }

    private fun selectedMarker(marker: Marker?) {
        val markerViewModel = marker?.tag as MarkerViewModel
        marker.setIcon(createIconMarker(markerViewModel.iconMarkerSelected))
    }

    private fun unSelectedMarker(marker: Marker?) {
        if (marker == null) {
            return
        }

        val markerViewModel = marker.tag as MarkerViewModel
        marker.setIcon(createIconMarker(markerViewModel.iconMarker))
    }

    override fun showMarker(mapViewModels: List<MarkerViewModel>) {
        googleMap?.clear()

        mapViewModels.forEach { addMarker(it) }

        focusMarkers(mapViewModels)
    }

    private fun focusMarkers(mapViewModels: List<MarkerViewModel>) {
        val builder = LatLngBounds.Builder()
        for (marker in mapViewModels) {
            builder.include(marker.latLng)
        }
        val bounds = builder.build()

        val cu = CameraUpdateFactory.newLatLngBounds(bounds, 90)
        googleMap?.animateCamera(cu)
    }

    private fun addMarker(markerViewModel: MarkerViewModel) {
        val markerOptions = MarkerOptions()
            .position(markerViewModel.latLng)
            .icon(createIconMarker(markerViewModel.iconMarker))

        val marker = googleMap?.addMarker(markerOptions)
        marker?.tag = markerViewModel
    }

    private fun createIconMarker(iconMarker: Int): BitmapDescriptor? {
        val vectorDrawable = ContextCompat.getDrawable(context!!, iconMarker)
        vectorDrawable?.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)
        val bitmap = Bitmap.createBitmap(
            vectorDrawable?.intrinsicWidth!!,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    override fun onDestroy() {
        presenter.onDestroy()

        super.onDestroy()
    }
}