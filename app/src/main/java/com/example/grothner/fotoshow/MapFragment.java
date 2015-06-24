package com.example.grothner.fotoshow;

import android.animation.Animator;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.Arrays;

/**
 * Created by Gregor on 17.06.2015.
 */
public class MapFragment extends Fragment {
    TextView date;
    TextView longitude;
    TextView latitude;
    private int selection = 0;

    protected MapView mapView;
    protected IMapController mapController;
    protected boolean useOnlineMap = true;
    private int zoom = 16;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map, container);
        mapView = (MapView) view.findViewById(R.id.map);
        date = (TextView) view.findViewById(R.id.dateInput);
        longitude = (TextView) view.findViewById(R.id.longitudeInput);
        latitude = (TextView) view.findViewById(R.id.latitudeInput);
        initMap();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void show(int pos, Image item) {
        Image image = item;
        date.setText(item.getDate());
        longitude.setText(item.getGeoPoint().getLongitudeE6());
        latitude.setText(item.getGeoPoint().getLatitudeE6());
        mapView.getController().setCenter(image.getGeoPoint());
    }

    private void initMap() {
        mapController = mapView.getController();
        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setMultiTouchControls(true);
        mapView.setBuiltInZoomControls(true);
        mapView.setUseDataConnection(useOnlineMap);
        mapController.setZoom(zoom);
    }

    /*private void addMarkers(final Image item)
    {
        final OverlayItem overlayItem = new OverlayItem(item.getId(), item.getDate(), item.getGeoPoint());
        overlayItem.setMarker(getResources().getDrawable(R.drawable.red));
        //Sp�ter sollte hier eine Miniaturansicht des Bildes sein !

        ItemizedOverlayWithFocus<OverlayItem> itemList = new ItemizedOverlayWithFocus<OverlayItem>(Arrays.asList(overlayItem),
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(int index, OverlayItem overlayItem1) {
                        createDialog(item);
                        return false;
                    }

                    @Override
                    public boolean onItemLongPress(int index, OverlayItem overlayItem1) {
                        return false;
                    }

                }, new DefaultResourceProxyImpl(getActivity()));
        itemList.setFocusItemsOnTap(true);
        mapView.getOverlays().add(itemList);
    }*/

   /* private void createDialog(final Image item)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Aktion ausw�hlen");
        alert.setSingleChoiceItems(R.array.actions, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selection = which;
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (selection == 0) {
                   //intent ausf�hren
                } else if (selection == 1) {
                   //intent ausf�hren
                }
            }
        });
        alert.setNegativeButton("Cancel", null);
        alert.show();
    }*/
}
