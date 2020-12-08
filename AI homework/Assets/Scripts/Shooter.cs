using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using UnityEngine;

public class Shooter : MonoBehaviour { 

    public float range = 8f;

    // Start is called before the first frame update
    void Start()
    {
        
    } 

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0)) {
            Vector3 mousepos = Camera.main.ScreenToWorldPoint(Input.mousePosition);
            Vector3 direction = (mousepos - transform.position).normalized;
            RaycastHit2D hit = Physics2D.Raycast(transform.position, direction, range);
            if (hit.collider != null) {
                // we hit something
                UnityEngine.Debug.Log("Hit somthing");
                UnityEngine.Debug.DrawLine(transform.position, hit.point, Color.white, 1f,false);
            }else {
                UnityEngine.Debug.DrawLine(transform.position, transform.position+direction *range, Color.white, 1f,false);
            }
        }
    }
}
